package playing_god

//Logger.log() should be called at the beginning of every function and print
// the function name and parameters.


class Logger {

	
	def static file = null
	
	
	
	static Log(String str){
			
		if (!file){
		
			def name = 'Log/Log1.txt'
			file = new File(name)
			if (file.exists()){
				file.delete()
			}
			file << "Log Start\n"
			
		}
		
		file << str
		
		
		
		
	}
}
