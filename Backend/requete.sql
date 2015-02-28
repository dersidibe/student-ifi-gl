SELECT *, get_distance_metres('21.041979', '105.782204', latStruct, lgStruct) 
      AS proximite 
      FROM structure
      Having proximite < 2000 ORDER BY proximite ASC 
      LIMIT 10

call get_structure('21.041979', '105.782204',3);

*********************************************

	
DROP FUNCTION IF EXISTS get_distance_metres|
CREATE FUNCTION get_distance_metres (lat1 DOUBLE, lng1 DOUBLE, lat2 DOUBLE, lng2 DOUBLE) RETURNS DOUBLE
BEGIN
    DECLARE rlo1 DOUBLE;
    DECLARE rla1 DOUBLE;
    DECLARE rlo2 DOUBLE;
    DECLARE rla2 DOUBLE;
    DECLARE dlo DOUBLE;
    DECLARE dla DOUBLE;
    DECLARE a DOUBLE;
    
    SET rlo1 = RADIANS(lng1);
    SET rla1 = RADIANS(lat1);
    SET rlo2 = RADIANS(lng2);
    SET rla2 = RADIANS(lat2);
    SET dlo = (rlo2 - rlo1) / 2;
    SET dla = (rla2 - rla1) / 2;
    SET a = SIN(dla) * SIN(dla) + COS(rla1) * COS(rla2) * SIN(dlo) * SIN(dlo);
    RETURN ROUND((6378137 * 2 * ATAN2(SQRT(a), SQRT(1 - a))),2);
END|


***********************************************


DROP PROCEDURE IF EXISTS get_structure|
CREATE PROCEDURE get_structure (lat1 DOUBLE, lng1 DOUBLE, typeStruct INT) 
BEGIN 
	DECLARE type INT;
	Set type = typeStruct;
	CASE type

		WHEN 1 THEN SELECT *, get_distance_metres(lat1, lng1, latStruct, lgStruct) AS distance FROM pharmacie
	 		Having distance < 2000 ORDER BY distance ASC LIMIT 10;

		WHEN 2 THEN SELECT *, get_distance_metres(lat1, lng1, latStruct, lgStruct) AS distance FROM clinique
	 		Having distance < 2000 ORDER BY distance ASC LIMIT 10;

		WHEN 3 THEN SELECT *, get_distance_metres(lat1, lng1, latStruct, lgStruct) AS distance FROM hopital
	 		Having distance < 2000 ORDER BY distance ASC LIMIT 10;
	END CASE;

END|



