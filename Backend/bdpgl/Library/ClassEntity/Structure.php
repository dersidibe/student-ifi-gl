<?php
	//***********@uthor SIDIBE Guéréguin Der Sylvestre*****************//	

	class Structure{

		private $id;
		private $name;
		private $latitude;
		private $longitude;
		private $telephone;
			
		public function __construct(){
		
			$this->id = "";
			$this->name = "";
			$this->latitude = "";
			$this->longitude = "";
			$this->telephone = "";			
		}
		
		//--------------Setter---------------//		
		public function setId($id){
		
			$this->id = $id;
		}
		
		public function setName($name){
		
			$this->name = $name;
		}
		
		public function setLatitude($latitude){
		
			$this->latitude = $latitude;
		}
		
		public function setLongitude($longitude){
			$this->longitude = $longitude;
		}
		
		public function setTelephone($telephone){
			$this->telephone = $telephone;
		}
		

		//-------------Getter--------------//
		public function getId(){
		
			return $this->id;
		}
		
		public function getName(){
		
			return $this->name;
		}
		
		public function getLatitude(){
		
			return $this->latitude;
		}
		
		public function getLongitude(){
			return $this->longitude;
		}
		
		public function getTelephone(){
			return $this->telephone;	
		}
		
	}
?>
