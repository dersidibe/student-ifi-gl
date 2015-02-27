<?php
	//***********@uthor SIDIBE Guéréguin Der Sylvestre*****************//	

	class Structure{

		private $id;
		private $name;
		private $latitude;
		private $longitude;
		private $telephone;
		private $rue;
		private $distance;
			
		public function __construct(){
		
			$this->id = "";
			$this->name = "";
			$this->latitude = "";
			$this->longitude = "";
			$this->telephone = "";	
			$this->rue = "";	
			$this->distance = "";			
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

		public function setRue($rue){
			$this->rue = $rue;
		}		

		public function setDistance($distance){
			$this->distance = $distance;
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

		public function getRue(){
			return $this->rue;	
		}

		public function getDistance(){
			return $this->distance;	
		}				
		
	}
?>
