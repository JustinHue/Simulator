
package playing_god

import com.sun.org.apache.bcel.internal.generic.RETURN;

import groovy.swing.SwingBuilder



import groovy.swing.j2d.GraphicsBuilder
import groovy.swing.j2d.GraphicsOperation
import groovy.swing.j2d.GraphicsPanel
import groovy.swing.j2d.operations.shapes.StarGraphicsOperation


import java.awt.Color
import java.awt.Dimension
import java.awt.Frame;
import java.awt.Graphics2D

import static javax.swing.JFrame.EXIT_ON_CLOSE

import java.util.logging.FileHandler
import java.util.logging.Level
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter
import javax.swing.JFrame
import javax.swing.JPanel

class Main {

	static IsRunning = true
	
	// DEFINE BUILDER OBJECTS
	static JFrame FRAME
	static JPanel PANEL
	static GraphicsOperation GO
	static GraphicsPanel GP
	
	// DEFINE BUILDERS
	static GraphicsBuilder GRAPHICS_BUILDER
	
	// DEFINE LOGGER AND FILE HANDLER
	static Logger LOGGER = Logger.getLogger(Main.class.getName())
	static FileHandler LOGGER_FH = null
	
	// DEFINE SIMULATOR OBJECTS
	static World WORLD
	
	static main(args) {

		// DEFINE LOGGER AND FILE HANDLER
		LOGGER_FH = new FileHandler("Log/main.log", true)
		LOGGER_FH.setFormatter(new SimpleFormatter())
		LOGGER.addHandler( Main.LOGGER_FH )
		LOGGER.setLevel(Level.ALL)
		
		// SET CONFIGURATION FILE AND GRAB CONFIG VALUES
		LOGGER.log(Level.FINE, "READING SIMULATOR CONFIG FILE")
		
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
		
		
		// CREATING SIMULATOR OBJECTS
		LOGGER.log(Level.FINE, "CREATING SIMULATOR OBJECTS")
		
		WORLD = new World()
		
		
		// CREATING GRAPHICS BUILDER
		LOGGER.log(Level.FINE, "CREATING GRAPHICS BUILDER")

		GRAPHICS_BUILDER = new GraphicsBuilder() 
		GP = new GraphicsPanel()
		
		// CREATING SWING BUILDER
		LOGGER.log(Level.FINE, "CREATING SWING BUILDER")

		SwingBuilder.build {
			FRAME = frame(title:cfgTitle, maximumSize:new Dimension(cfgMaximumSize[0].toInteger(), cfgMaximumSize[1].toInteger()),
				minimumSize:new Dimension(cfgMinimumSize[0].toInteger(), cfgMinimumSize[1].toInteger()),
				preferredSize:new Dimension(cfgPreferredSize[0].toInteger(), cfgPreferredSize[1].toInteger()),
				resizable: cfgResizable, show:cfgShowing, defaultCloseOperation: cfgDefaultCloseOperation,
				locationRelativeTo: cfgLocationRelativeTo, state:cfgState, undecorated:cfgUndecorated) {
				
				PANEL = panel( GP )
			}
			
			if (cfgLocationX != null && cfgLocationY != null) {
				FRAME.setLocation(cfgLocationX.toInteger(), cfgLocationY.toInteger())
			}
		}

		
		// RUN MAIN THREAD
		LOGGER.log(Level.FINE, "CREATING MAIN THREAD")
		new Thread({
			Main.run()
		} as Runnable).start()
				
	}

	static render() {
		GO = GRAPHICS_BUILDER.group( borderColor: 'blue', borderWidth: 4, fill: 'cyan' ) {
			WORLD.update()
		    rect( x: 10, y: 10, width: 290, height: 80, arcWidth: 20, arcHeight: 20 )
		    circle( cx: 90, cy: 80, radius: 50, borderColor: 'darkRed', fill: 'red' )
		    polygon(points: [175, 38, 229, 69, 229, 131, 175, 162, 121, 131, 121, 69])

		}
		
		GP.setGo(GO)
	}
	
	static update() {

	}
	
	static run() {
		LOGGER.log(Level.FINE, "RUNNING MAIN THREAD")
		while (Main.IsRunning) {
			System.nanoTime()
			Main.render()
			Main.update()
		}
	}
	
}



