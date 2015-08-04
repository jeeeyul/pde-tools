package net.jeeeyul.pdetools.shared;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class PlayThread extends Job {
	private static int LAST_JOB_HASH;
	private InputStream stream;

	private Position curPosition;

	private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb

	enum Position {
		LEFT, RIGHT, NORMAL
	};

	public PlayThread(InputStream is) {
		super("SFX");
		setUser(false);
		setSystem(true);
		this.stream = is;
		this.curPosition = Position.NORMAL;
		LAST_JOB_HASH = hashCode();
	}

	@Override
	public boolean shouldRun() {
		return hashCode() == LAST_JOB_HASH;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(this.stream));
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
			return Status.OK_STATUS;
		} catch (IOException e1) {
			e1.printStackTrace();
			return Status.OK_STATUS;
		}

		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			return Status.OK_STATUS;
		} catch (Exception e) {
			e.printStackTrace();
			return Status.OK_STATUS;
		}

		if (auline.isControlSupported(FloatControl.Type.PAN)) {
			FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
			if (this.curPosition == Position.RIGHT) {
				pan.setValue(1.0f);
			} else if (this.curPosition == Position.LEFT) {
				pan.setValue(-1.0f);
			}
		}

		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[this.EXTERNAL_BUFFER_SIZE];

		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0) {
					auline.write(abData, 0, nBytesRead);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return Status.OK_STATUS;
		} finally {
			auline.drain();
			auline.close();
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.stream = null;
			this.curPosition = null;
		}

		return Status.OK_STATUS;
	}
}