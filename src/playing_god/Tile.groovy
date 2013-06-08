package playing_god

class Tile {

	def static SIZE
	def static TILE_INFO = [[:]]
	
	def static load_tile_info(def datafile) {
		def file = new File(datafile)
		def indexCounter = 0
		file.eachLine { line ->
			line = line.trim()
			if (!line.isEmpty()) {
				def attributes = line.split(",")
				Tile.TILE_INFO[attributes].putAt('type',attributes[0])
				Tile.TILE_INFO[attributes].putAt('color',attributes[1])
				++indexCounter
			}
		}
	} 
	
	private def type
	
	Tile(def type) {
		this.type = type
	}
	
	Tile() {
		this.type = 0
	}
	
	def getType() {
		return this.type
	}
	
	def changeType(def nType) {
		this.type = nType
	}
	
}
