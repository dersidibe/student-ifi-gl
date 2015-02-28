<?php
//***********@uthor SIDIBE Guéréguin Der Sylvestre*****************//

require_once('ClassConnector/class.DBConnector.php');
require_once('ClassEntity/Structure.php');

class Fonction extends DataBase {

	private $_connexion;
	private $_reponse;
	private $_check;

	//---------------Class constructor-------------------------//

	public function __construct() {

		$this->_connexion = parent::getInstance()->DBConnexion();
		$this->_reponse = "";
		date_default_timezone_set('Africa/Ouagadougou');
	}
	
	public function getPharmacieJson($lat, $lng,$type){
			
		
		$this->_reponse = $this->_connexion->prepare("call get_structure(:lat, :lng,:type)");
		$this->_reponse->bindParam(':lat', $lat, PDO::PARAM_STR);
		$this->_reponse->bindParam(':lng', $lng, PDO::PARAM_STR);
		$this->_reponse->bindParam(':type', $type, PDO::PARAM_INT);
		$_test = $this->_reponse->execute();
		$tab = array();
		if ($_test) {
			$this->_reponse->setFetchMode(PDO::FETCH_OBJ);
			while ($select = $this->_reponse->fetch()) {
				$tab ['pharmacie'][] = $select;
			}
		} else
			$tab ['pharmacie'][] = 0;
		return json_encode($tab);
			
	}		
	public function getPharmacie($lat, $lng, $type){
			
		
		$this->_reponse = $this->_connexion->prepare("call get_structure(:lat, :lng, :type)");
		$this->_reponse->bindParam(':lat', $lat, PDO::PARAM_STR);
		$this->_reponse->bindParam(':lng', $lng, PDO::PARAM_STR);
		$this->_reponse->bindParam(':type', $type, PDO::PARAM_INT);
		$_test = $this->_reponse->execute();
		$structure[] = null;

		if ($_test) {

			$this->_reponse->setFetchMode(PDO::FETCH_OBJ);
			$i = 0;
			while ($data = $this->_reponse->fetch()) {
							
					$structure[$i] = new Structure();
					$structure[$i]->setId($data->idStruct);
					$structure[$i]->setName($data->nomStruct);
					$structure[$i]->setLatitude($data->latStruct);
					$structure[$i]->setLongitude($data->lgStruct);
					$structure[$i]->setTelephone($data->telStruct);
					$structure[$i]->setRue($data->rueStruct);
					$structure[$i]->setDistance($data->distance);
					$i = $i+1;
			}
		}

		return $structure;
	}		
			
}

