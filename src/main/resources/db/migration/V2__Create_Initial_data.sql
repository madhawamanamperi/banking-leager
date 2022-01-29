INSERT INTO `customer` (`created_by`, `created_date`, `address`, `customer_code`, `first_name`, `last_name`) VALUES ('root', '0', 'Panadura', 'C001', 'Madhawa', 'Manamperi');
INSERT INTO `vault` (`created_date`, `balance`, `vault_id`, `customer_id`) VALUES ('0', '0', 'V001', '1');
UPDATE `customer` SET `modified_by` = '0', `modified_date` = '0' WHERE (`id` = '1');
UPDATE `vault` SET `modified_by` = '', `modified_date` = '0' WHERE (`id` = '1');

INSERT INTO `customer` (`created_by`, `created_date`, `address`, `customer_code`, `first_name`, `last_name`) VALUES ('root', '0', 'Bandaragama', 'C002', 'Ruwan', 'Silwa');
UPDATE `customer` SET `modified_by` = '0', `modified_date` = '0' WHERE (`id` = '2');

INSERT INTO `vault` (`created_date`, `balance`, `vault_id`, `customer_id`) VALUES ('0', '0', 'V002', '1');
UPDATE `vault` SET `modified_by` = '', `modified_date` = '0' WHERE (`id` = '2');

INSERT INTO `vault` (`created_date`, `balance`, `vault_id`, `customer_id`) VALUES ('0', '0', 'V003', '2');
UPDATE `vault` SET `modified_by` = '', `modified_date` = '0' WHERE (`id` = '3');