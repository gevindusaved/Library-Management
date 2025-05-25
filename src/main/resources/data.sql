INSERT INTO books (title, author, isbn, available) VALUES
('The Pragmatic Programmer', 'Andrew Hunt', '978-0201616224', TRUE),
('Clean Code', 'Robert C. Martin', '978-0132350884', TRUE),
('Effective Java', 'Joshua Bloch', '978-0134685991', FALSE),
('Design Patterns', 'Erich Gamma', '978-0201633610', TRUE),
('Design Patterns', 'Joshua Bloch', '978-0201633611', TRUE),
('Introduction to Algorithms', 'Thomas H. Cormen', '978-0262033848', FALSE);

INSERT INTO members (name, email, membership_date) VALUES
('Alice Johnson', 'alice.johnson@example.com', '2023-01-15'),
('Bob Smith', 'bob.smith@example.com', '2022-11-03'),
('Carol Lee', 'carol.lee@example.com', '2024-04-20'),
('David Kim', 'david.kim@example.com', '2023-07-12'),
('Eva Brown', 'eva.brown@example.com', '2021-09-08'),
('Frank Miller', 'frank.miller@example.com', '2022-02-28');

INSERT INTO borrow_records (book_id, member_id, borrow_date, return_date)
VALUES 
  (1, 1, '2025-04-01', '2025-04-15'),
  (2, 2, '2025-04-05', '2025-04-20'),
  (2, 3, '2025-04-10', NULL),
  (3, 4, '2025-04-12', '2025-04-22'),
  (5, 5, '2025-04-15', NULL),
  (6, 6, '2025-04-20', '2025-05-01');


