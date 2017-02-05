
--Setup Data
INSERT INTO `CUSTOMER_TYPE` VALUES (1,'Platinum',200000);
INSERT INTO `CUSTOMER_TYPE` VALUES (2,'Gold',100000);
INSERT INTO `CUSTOMER_TYPE` VALUES (3,'Silver',25000);
INSERT INTO `CUSTOMER_TYPE` VALUES (4,'Bronze',5000);
INSERT INTO `CUSTOMER_TYPE` VALUES (5,'Walk-in',0);

INSERT INTO `TESTCATEGORY` VALUES (1,'Chemical');
INSERT INTO `TESTCATEGORY` VALUES (2,'Mechanical');
INSERT INTO `TESTCATEGORY` VALUES (3,'Non-Destructive');
INSERT INTO `TESTCATEGORY` VALUES (4,'Metallography');
INSERT INTO `TESTCATEGORY` VALUES (5,'Misc');


INSERT INTO `TESTTYPE` VALUES (1,'Spectro','Sample Description for Spectro',500,1);
INSERT INTO `TESTTYPE` VALUES (2,'Edxrf','Sample Description for Edxrf',200,1);
INSERT INTO `TESTTYPE` VALUES (3,'Coating','Sample Description for Coating',300,1);
INSERT INTO `TESTTYPE` VALUES (4,'Tensile','Sample Description for Tensile',700,2);
INSERT INTO `TESTTYPE` VALUES (5,'Hardness','Sample Description for Hardness',950,2);
INSERT INTO `TESTTYPE` VALUES (6,'Bend','Sample Description for Bend',1100,2);




--Sample Data
INSERT INTO `CUSTOMER` VALUES (7727621757672095745,'Customer ABC','+91 9878987878787','PAN-1ANDKEW',1);

INSERT INTO `CUSTOMER_CONTACT` VALUES (7727621757672095745,'Cheryl','Cheryl@kony.com','29784735')
INSERT INTO `CUSTOMER_CONTACT` VALUES (7727621757672095745,'Clark','Clark@kony.com','+19898998');


INSERT INTO `CUSTOMER` VALUES (7727621757672095746,'Customer XYZ','+91 9898877676','PAN-2ANDKEW',5);

INSERT INTO `CUSTOMER_CONTACT` VALUES (7727621757672095745,'Ram','Raml@gxyz.com','040-2978 4735')
INSERT INTO `CUSTOMER_CONTACT` VALUES (7727621757672095745,'Venkat','Venkat@xyz.com','040-4000 9965');




INSERT INTO `SAMPLE` VALUES (7728653054506958849,7727621757672095745,'Powder','2017-02-05','Received',0,'CARVED WITH BIPIN','Y');
INSERT INTO `WORKORDER` VALUES (7728676227600351233,7727621757672095745,'URGENT: Customer wants this completed on time.','Self','2017-02-05','2017-02-05','New','2017-04-01',0);
