package playing_god

import java.util.Random

class World {

	private def tiles
	
	
	
	
	
	
	World(def size) {
		Random rand = new Random()
		tiles = [size].each { row ->
			row = [size].each { type ->
				type = new Tile(rand.nextInt(9))
				print(tiles.size())
			}
		}
	}
	
	def getTileAt(def column, def row) {
		print(tiles[1])

	}
	
	def getSize() {
		return tiles[0].size()
	}

}
