package playing_god

import com.sun.org.apache.bcel.internal.generic.RETURN;

import groovy.swing.SwingBuilder
import groovy.swing.j2d.GraphicsBuilder
import groovy.swing.j2d.GraphicsPanel
import static javax.swing.JFrame.EXIT_ON_CLOSE
/*

class Main {
	
	static main(args) {
		
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
		
		def world = new World(worldSize)

		
		def gb = new GraphicsBuilder()
		
		def go = gb.group {
		   rect( x: 0, y: 0, width: reswidth, height: resheight, borderColor: innerBorderColor, fill: backgroundColor )
		   
		   for (def column = 0; column < Tile.SIZE; ++column) {
			   for (def row = 0; row < Tile.SIZE; ++row) {
				 	def tile = world.getTileAt(column, row)

			   }
		   }
		}
		  

	}
}

*/

def world = new World(32, 64)
print world.getSizeY()

