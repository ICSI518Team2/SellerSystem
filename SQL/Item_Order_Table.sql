CREATE TABLE IF NOT EXISTS `item` (
  `id` int(11) NOT NULL,
  `seller_id` int(11) NOT NULL,
  `category` varchar(255) NOT NULL,
  `cost_price` varchar(255) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `selling_price` varchar(255) NOT NULL,
  `status` bit(1) NOT NULL,
  `description` varchar(1024), 
  `image_path` varchar(1024),
  PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `order` (
  `id` int(11) NOT NULL,
  `seller_id` int(11) NOT NULL,
  `buyer_id` int(11) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `selling_price` varchar(255) NOT NULL,
  `order_status` bit(1) NOT NULL,
  `description` varchar(1024), 
  `image_path` varchar(1024),
  PRIMARY KEY (`id`)
);