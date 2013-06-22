
package playing_god

import com.sun.org.apache.bcel.internal.generic.RETURN;

import groovy.swing.SwingBuilder

import groovy.swing.j2d.GraphicsBuilder
import groovy.swing.j2d.GraphicsPanel

import java.awt.Dimension
import java.awt.Frame;

import static javax.swing.JFrame.EXIT_ON_CLOSE

import java.util.logging.FileHandler
import java.util.logging.Level
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter

class Main {
	
	static Logger LOGGER = Logger.getLogger(Main.class.getName());
	static FileHandler FH = null
	
	static main(args) {

		// DEFINE LOGGER AND FILE HANDLER
		FH = new FileHandler("Log/main.log", true)
		FH.setFormatter(new SimpleFormatter())
		
		LOGGER.addHandler(FH)
		
		LOGGER.setLevel(Level.ALL)
		LOGGER.log(Level.FINE, "SDFDS")
		
		// SET CONFIGURATION FILE AND GRAB CONFIG VALUES
		Configuration.set_config_file("simulator.cfg")
		
		def cfgTitle = Configuration.get_config_value("title", "").toString()
		def cfgMaximumSize = Configuration.get_config_value("maximumSize", "800,600").toString().split(",")
		def cfgMinimumSize = Configuration.get_config_value("minimumSize", "800,600").toString().split(",")
		def cfgPreferredSize = Configuration.get_config_value("preferredSize", "800,600").toString().split(",")
		def cfgResizable = Configuration.get_config_value("resizable", true).toBoolean()
		def cfgShowing = Configuration.get_config_value("showing", true).toBoolean()
		def cfgDefaultCloseOperation = Configuration.get_config_value("defaultCloseOperation", 3).toInteger()
		def cfgLocationRelativeTo = Configuration.get_config_value("locationRelativeTo", "null") == "null" ? null : null
		def cfgState = Configuration.get_config_value("state", Frame.NORMAL).toInteger()
		def cfgUndecorated = Configuration.get_config_value("undecorated", true).toBoolean()

		
		def cfgLocationX = Configuration.get_config_value("locationX", null)
		def cfgLocationY = Configuration.get_config_value("locationY", null)
		
		/*
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
								resizable: cfgResizable, show:cfgShowing, defaultCloseOperation: cfgDefaultCloseOperation,
								locationRelativeTo: cfgLocationRelativeTo, state:cfgState, undecorated:cfgUndecorated) {
				
			}
				
			if (cfgLocationX != null && cfgLocationY != null) {		
				frame.setLocation(cfgLocationX.toInteger(), cfgLocationY.toInteger())
			}
			
		}

	}
}



