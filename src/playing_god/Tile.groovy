package playing_god

import groovy.swing.j2d.GraphicsBuilder
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

	}
	
	def draw(GraphicsBuilder gb) {
		gb.rect( x: 10, y: 10, width: 300, height: 80, borderColor: 'blue', borderWidth: 2, fill: 'cyan', arcWidth: 20, arcHeight: 20)
	}
	
	
}
