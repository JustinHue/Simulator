package playing_god

class Configuration {

	private def static configMap = [:]
	
	def static get_config_value(def keyName, def defaultValue) {
		return configMap[keyName] ? configMap[keyName] : defaultValue
	}
	
	def static set_config_file(def cfgfile) {
		def file = new File(cfgfile)
		file.eachLine { line ->
			line = line.trim()
			if (!line.isEmpty()) {
				def pair = line.split("=")
				if (pair.size() == 2) {
					configMap.putAt(pair.getAt(0), pair.getAt(1))
				}
			}
		}
		
	}
	
}
