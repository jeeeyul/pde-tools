package net.jeeeyul.pdetools.shared

class AverageComputer {
	double average
	int count
	
	def push(double value){
		this.count = this.count + 1
		average = (average * ((this.count - 1) / this.count as double)) + (value * 1.0 / this.count as double)
		return average 
	}
	
	def reset(){
		average = 0
		count = 0
	}
	
	def getAverage(){
		return average
	}
	
	def static void main(String[] args){
		var ac = new AverageComputer()
		println(ac.push(1))
		println(ac.push(2))
		println(ac.push(3))
		println(ac.push(18))
	}
}