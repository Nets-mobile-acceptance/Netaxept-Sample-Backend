insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000001', 'Bon Scott');
insert into CONSUMERS(CONSUMER_ID_PK, NAME, card_verification_subsequent)
  values ('000002', 'Janis Jopplin', false);
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000003', 'Jim Morrison');
insert into CONSUMERS(CONSUMER_ID_PK, NAME, card_verification_subsequent)
  values ('000004', 'Curt Cobain', false);
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000005', 'Jimmy Hendrix');
insert into CONSUMERS(CONSUMER_ID_PK, NAME, card_verification_subsequent)
  values ('000006', 'Freddie Mercury', false);  
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000007', 'Bob Marley'); 
insert into CONSUMERS(CONSUMER_ID_PK, NAME, card_verification_subsequent)
  values ('000008', 'Frank Zappa', false);
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000009', 'Amy Winehouse');
insert into CONSUMERS(CONSUMER_ID_PK, NAME, card_verification_subsequent)
  values ('000010', 'Joe Ramone', false);
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000011', 'Mark Bolan');  
insert into CONSUMERS(CONSUMER_ID_PK, NAME, card_verification_subsequent)
  values ('000012', 'Sid Vicious', false);
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000013', 'Ronnie James Dio');
insert into CONSUMERS(CONSUMER_ID_PK, NAME, card_verification_subsequent)
  values ('000014', 'Phil Lynott', false);
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000015', 'Lou Reed');
insert into CONSUMERS(CONSUMER_ID_PK, NAME, card_verification_subsequent)
  values ('000016', 'Gary Moore', false);  
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000017', 'Peter Tosh');  
insert into CONSUMERS(CONSUMER_ID_PK, NAME, card_verification_subsequent)
  values ('000018', 'Ronnie Van  Zant', false);  
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000019', 'George Harrison');  
insert into CONSUMERS(CONSUMER_ID_PK, NAME, card_verification_subsequent)
  values ('000020', 'Cliff Burton', false);  
  
insert into CONSUMERS(CONSUMER_ID_PK, NAME, card_verification_subsequent)
  values ('999998', 'Jane Doe',false);
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('999999', 'John Doe');  
  
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000100', 'Tester1');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000101', 'Tester2');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000102', 'Tester3');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000103', 'Tester4');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000104', 'Tester5');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000105', 'Tester6');  
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000106', 'Tester7');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000107', 'Tester8');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000108', 'Tester9');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000109', 'Tester10');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000110', 'Tester11');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000111', 'Tester12');  
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000112', 'Tester13');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000113', 'Tester14');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000114', 'Tester15');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000115', 'Tester16');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000116', 'Tester17');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000117', 'Tester18');  
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000118', 'Tester19');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000119', 'Tester20');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000120', 'Tester21');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000121', 'Tester22');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000122', 'Tester23');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000123', 'Tester24');  
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000124', 'Tester25');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000125', 'Tester26');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000126', 'Tester27');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000127', 'Tester28');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000128', 'Tester29');
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000129', 'Tester30');  
insert into CONSUMERS(CONSUMER_ID_PK, NAME)
  values ('000130', 'Tester31');
  
  
  
  
  
insert into CARDTOKENS(NAME, VALUE, ISSUER, EXPIRY_DATE, CONSUMER_ID_FK)
  values ('123456XXXXXX0000', 'UnVuIFRvIHRoZSBoaWxscy4uLi4=', 'Visa', '02/20',  '999998');
insert into CARDTOKENS(NAME, VALUE, ISSUER, EXPIRY_DATE, CONSUMER_ID_FK)
  values ('123456XXXXXX0001', 'UnVuIFRvIHRoZSBoaWxscy4uLi4=', 'Visa', '04/18',  '999998');
insert into CARDTOKENS(NAME, VALUE, ISSUER, EXPIRY_DATE, CONSUMER_ID_FK)
  values ('123456XXXXXX0000', 'UnVuIFRvIHRoZSBoaWxscy4uLi4=', 'Visa', '02/20',  '999999');
insert into CARDTOKENS(NAME, VALUE, ISSUER, EXPIRY_DATE, CONSUMER_ID_FK)
  values ('123456XXXXXX0001', 'UnVuIFRvIHRoZSBoaWxscy4uLi4=', 'Visa', '04/18',  '999999');