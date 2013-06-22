package playing_god

import java.util.Random

class World {

	private def tiles
	private def entities
	
	World(def size_w = 0, def size_h = 0) {
		tiles = new Tile[size_h][size_w]
		entities = []
	}
	
	def getTileAt(def column, def row) {
		return tiles[column][row]
	}
	
	def getSizeX() {
		return tiles[0].size()
	}
	
	def getSizeY() {
		return tiles.size()	
	}
	
	def getTotalSize() {
		return tiles.size() * tiles[0].size()
	}
	
	def getEntities() {
		return entities	
	}
	
	def update() {
		tiles.each { it.update() }
	}
	
	def draw() {
		
	}

}
