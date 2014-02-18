package net.jeeeyul.pdetools.shared;

public interface ProgressModifier {
	public class BOUNCE implements ProgressModifier {
		private int bounceCount;

		public BOUNCE(int bounceCount) {
			super();
			this.bounceCount = bounceCount;
		}

		@Override
		public double modify(double progress) {
			double result = 1d - Math.abs(Math.cos(progress * Math.PI * (bounceCount + .5d)));
			return result;
		}

		public static final BOUNCE derive(int bounceCount) {
			return new BOUNCE(bounceCount);
		}
	}

	public static final ProgressModifier EASE_IN = new ProgressModifier() {
		@Override
		public double modify(double p) {
			return p * p;
		}
	};

	public static final ProgressModifier EASE_IN_EASE_OUT = new ProgressModifier() {
		@Override
		public double modify(double progress) {
			if (progress <= .5d) {
				return EASE_IN.modify(progress * 2d) / 2d;
			} else {
				return EASE_OUT.modify((progress - .5d) * 2d) / 2d + .5d;
			}
		}
	};

	public static final ProgressModifier EASE_OUT = new ProgressModifier() {
		@Override
		public double modify(double p) {
			return 2 * p - p * p;
		}
	};

	public double modify(double progress);

}
