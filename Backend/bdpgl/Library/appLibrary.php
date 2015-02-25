<?php
//***********@uthor SIDIBE Guéréguin Der Sylvestre*****************//

require_once('ClassConnector/class.DBConnector.php');

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
	
	public function getPharmacie($lat, $lng){
			
		
		$this->_reponse = $this->_connexion->prepare("call get_structure(:lat, :lng)");
		$this->_reponse->bindParam(':lat', $lat, PDO::PARAM_STR);
		$this->_reponse->bindParam(':lng', $lng, PDO::PARAM_STR);
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


	public function afficheInfosTechniqueTicket($id_ticket) {

		$this->_reponse = $this->_connexion->prepare("select t.numero_concerne,p.numero_pt,p.nom_pt,s.numero_distribution,r.transport1 from ticket t,pt p,sr s,re r
				where t.id_pt = p.id_pt and p.numro_sr = s.numro_sr and r.transport1 = s.transport1 and t.id_ticket = :id");
		$this->_reponse->bindValue(':id', $id_ticket, PDO::PARAM_STR);
		$_test = $this->_reponse->execute();
		$tab = array();
		if ($_test) {
			$this->_reponse->setFetchMode(PDO::FETCH_OBJ);
			while ($_select = $this->_reponse->fetch()) {
				$tab ['techniques'][] = $_select;
			}
		} else
			$tab ['techniques'][] = 0;
		return json_encode($tab);
	}
			
}
?>
