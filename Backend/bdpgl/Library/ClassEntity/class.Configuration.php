<?php
	class Entity {

//------------Déclaration des variables pour la connexion à la base de données--------//	

		private $_db ;  			//type de SGBDR
		private $_db_name; 			//Nom de la base de donnée
		private $_db_login; 		//Nom d'utilisateur 
		private $_db_passwd; 		//Mot de passe pour se connecter à la BD
		private $_db_host;		 	// Hoste sur lequel la base de données est installée
		
//---------------Fin Déclaration des variables de connexion-----------------------//

		public function __construct(){
			
			//------------Base de données---------//
		
			$this->_db = 'mysql';
			$this->_db_name = 'bdpgl';
			$this->_db_login = 'root';
			$this->_db_passwd = 'ephphata';
			$this->_db_host = 'localhost';
			/*
			$this->_db = 'mysql';
			$this->_db_name = '1818932_bdpgl';
			$this->_db_login = '1818932_bdpgl';
			$this->_db_passwd = 'ephphata87';
			$this->_db_host = 'fdb13.awardspace.net';

			
			$this->_db = 'mysql';
			$this->_db_name = 'zoumacra_bdpgl';
			$this->_db_login = 'zoumacra_root';
			$this->_db_passwd = 'ephphata';
			$this->_db_host = 'localhost';
				
			*/	
			
			//------------Fin Base de données-----//	
	
		}
		
		public function getDB(){
		
			return $this->_db;
		}
		public function getDBName(){
		
			return $this->_db_name;
		}
		
		public function getDBLogin(){
		
			return $this->_db_login;
		}

		public function getDBPassword(){
		
			return $this->_db_passwd;
		}
		
		public function getDBHost(){
		
			return $this->_db_host;
		}		

	}
?>
