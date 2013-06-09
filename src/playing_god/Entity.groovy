package playing_god


class Entity {

	private def x, y
	private def width, height
	private def xSpeed, ySpeed
	
	Entity(x = 0, y = 0, width = 0, height = 0) {
		this.x = x
		this.y = y
		this.width = width
		this.height = height
		this.xSpeed = this.ySpeed = 0
	}
	
	def getX() {
		return this.x
	}
	
	def getY() {
		return this.y
	}
	
	def getWidth() {
		return this.width	
	}
	
	def getHeight() {
		return this.height	
	}
	
	def getSpeed() {
		return [this.xSpeed, this.ySpeed]
	}
	
	def update() {
		
	}

}
