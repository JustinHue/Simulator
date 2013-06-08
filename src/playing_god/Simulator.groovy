package playing_god

import groovy.swing.SwingBuilder

class Simulator {
	
	static def frame
	
	def static init() {
		
		Simulator.frame = SwingBuilder.frame()
		
		Configuration.set_config_file("world/config.cfg")
		
		def defaultCloseOperation = Configuration.get_config_value("defaultCloseOperation", true).toString().toBoolean()
		def resizable = Configuration.get_config_value("resizable", true).toString().toBoolean()
		
		
		
		def reswidth = Configuration.get_config_value("reswidth", 800).toInteger()
		def resheight = Configuration.get_config_value("resheight", 600).toInteger()
		
		def title = Configuration.get_config_value("title", "").toString()
		
		def centerWindow = Configuration.get_config_value("centerWindow", true).toBoolean()
		def windowVisisble = Configuration.get_config_value("windowVisisble", true).toBoolean()
		
		def backgroundColor = Configuration.get_config_value("backgroundColor", "black").toString()
		def innerBorderColor = Configuration.get_config_value("innerBorderColor", "black").toString()
		
		//def backgroundWidth = Configuration.get_config_value("backgroundWidth", 800).toInteger()
		def worldSize = Configuration.get_config_value("worldSize", 32).toInteger()
		Tile.SIZE = Configuration.get_config_value("tilesize", 32).toInteger()
	}
	
	def static deinit() {

		
	}
	
	def static update() {
		
	}
	
	def static render() {

	}
	
}
