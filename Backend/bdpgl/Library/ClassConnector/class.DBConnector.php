<?php
require('../Library/ClassEntity/class.Configuration.php');
//***********@uthor SIDIBE Guéréguin Der Sylvestre*****************//

	class DataBase{
	//------------This class deals with the connexion to the database only------------//
	private $_connexion;
	private $_dns;
	private $_login;
	private $_passwd;
	private $_options;
	private $_entity;
	
		private function __construct(){
		
				$this->_entity = new Entity();
				
				$this->_dns = $this->_entity->getDB().':host='.$this->_entity->getDBHost().'; dbname='.$this->_entity->getDBName();
				$this->_login = $this->_entity->getDBLogin();
				$this->_passwd = $this->_entity->getDBPassword();
				$this->_options = array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8", PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION);
		}
		
		private function __clone(){
		
		}
		
		public static function getInstance() {
			
				static $instance;
		 
				if ($instance === null) {
				
					$instance = new self();			
				}
		 
				return $instance;
		}
		
		public function DBConnexion(){
		
				try{
				
					$this->_connexion = new PDO( $this->_dns,$this->_login,$this->_passwd, $this->_options );
					
					return $this->_connexion;
					
				}catch(Exception $e){
				
					echo "Accès impossible à la base de données MySQL!", $e->getMessage();
					die();
					
				}
		}
		
	}
?>