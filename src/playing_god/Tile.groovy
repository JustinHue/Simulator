package playing_god

import java.util.logging.Level

class Tile {

	private def type
	
	Tile(type = 0) {
		this.type = type
	}	

	def getType() {
		return this.type
	}
	
	def update() {
		Main.LOGGER.log(Level.FINE, "Updating tile:reference:" + this)
	}
	
	def draw() {
		Main.LOGGER.log(Level.FINE, "Drawing tile:reference:" + this)
	}
	
	
}
