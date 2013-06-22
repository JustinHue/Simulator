
package playing_god

import com.sun.org.apache.bcel.internal.generic.RETURN;

import groovy.swing.SwingBuilder

import groovy.swing.j2d.GraphicsBuilder
import groovy.swing.j2d.GraphicsPanel

import java.awt.Dimension
import java.awt.Frame;

import java.util.logging.Logger;

class Main {
	
	static Logger LOGGER = Logger.getLogger("InfoLogging");
	
	static main(args) {
		
		
		Configuration.set_config_file("simulator.cfg")
		
		def cfgTitle = Configuration.get_config_value("title", "").toString()
		def cfgMaximumSize = Configuration.get_config_value("maximumSize", "800,600").toString().split(",")
		def cfgMinimumSize = Configuration.get_config_value("minimumSize", "800,600").toString().split(",")
		def cfgPreferredSize = Configuration.get_config_value("preferredSize", "800,600").toString().split(",")
		
		def cfgAlignmentX = Configuration.get_config_value("alignmentX", 0).toFloat()
		def cfgAlignmentY = Configuration.get_config_value("alignmentY", 0).toFloat()

		/*
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
		  */
		
		def swing = new SwingBuilder()
		
		swing.edt {
			frame = swing.frame(title:cfgTitle, maximumSize:new Dimension(cfgMaximumSize[0].toInteger(), cfgMaximumSize[1].toInteger()), 
								minimumSize:new Dimension(cfgMinimumSize[0].toInteger(), cfgMinimumSize[1].toInteger()),
								preferredSize:new Dimension(cfgPreferredSize[0].toInteger(), cfgPreferredSize[1].toInteger()),
								
								null, pack:true, show:true) {
				
			}
							

		}

	}
}



