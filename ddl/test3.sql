  SELECT
        order_id
        , product_id
        , order_qty
        , create_at
        FROM monkey.order
        ORDER BY order_id ASC
        ;
        
        	SELECT 1 AS COL1 
            ;
        
        commit
        ;
        
        INSERT INTO monkey.order (product_id, order_qty) VALUES
('A', 1),
('B', 2),
('C', 5),
('D', 10),
('A', 1),
('D', 3),
('B', 4),
('V', 6),
('C', 10),
('D', 100),
('F', 2),
('E', 5),
('E', 6),
('F', 8),
('W', 12),
('Q', 15),
('A', 21),
('Z', 45),
('X', 33),
('C', 112),
('V', 144),
('B', 12),
('G', 168),
('R', 14);
