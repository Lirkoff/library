# INSERT INTO roles(id, role)
# VALUES (1,'ROLE_USER'),
#        (2,'ROLE_MODERATOR'),
#        (3,'ROLE_ADMIN');


# INSERT INTO book (id, title, author, description, copies, copies_available, category, img)
# VALUES (1, 'Mastering Java', 'Smith, John', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.',
#         5, 5, 'BE', '/Images/BooksImages/new-book-1.webp'),
#        (2, 'Data Science Handbook', 'Johnson, Emily',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 3, 3, 'DATA',
#         '/Images/BooksImages/new-book-1.webp'),
#        (3, 'Frontend Development with React', 'Brown, Michael',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 4, 4, 'FE',
#         '/Images/BooksImages/new-book-1.webp'),
#        (4, 'DevOps Revolution', 'Davis, Sarah',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 6, 6, 'DevOps',
#         '/Images/BooksImages/new-book-1.webp'),
#        (5, 'JavaScript for Beginners', 'Wilson, Robert',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 7, 7, 'FE',
#         '/Images/BooksImages/new-book-1.webp'),
#        (6, 'Advanced MySQL Techniques', 'Moore, Patricia',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 5, 5, 'DATA',
#         '/Images/BooksImages/new-book-1.webp'),
#        (7, 'Python Machine Learning', 'Taylor, Mary',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 6, 6, 'DATA',
#         '/Images/BooksImages/new-book-1.webp'),
#        (8, 'Spring Framework Essentials', 'Anderson, James',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 4, 4, 'BE',
#         '/Images/BooksImages/new-book-1.webp'),
#        (9, 'Cloud Computing for DevOps', 'Thomas, Linda',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 8, 8, 'DevOps',
#         '/Images/BooksImages/new-book-1.webp'),
#        (10, 'Understanding Databases', 'Martin, Barbara',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 3, 3, 'DATA',
#         '/Images/BooksImages/new-book-1.webp'),
#        (11, 'Angular in Action', 'Jackson, William',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 5, 5, 'FE',
#         '/Images/BooksImages/new-book-1.webp'),
#        (12, 'Java Concurrency Mastery', 'White, Elizabeth',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 6, 6, 'BE',
#         '/Images/BooksImages/new-book-1.webp'),
#        (13, 'Docker Containers Explained', 'Harris, Christopher',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 7, 7, 'DevOps',
#         '/Images/BooksImages/new-book-1.webp'),
#        (14, 'Data Structures with Python', 'Clark, Jennifer',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 4, 4, 'DATA',
#         '/Images/BooksImages/new-book-1.webp'),
#        (15, 'Modern CSS Techniques', 'Lewis, Richard',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 8, 8, 'FE',
#         '/Images/BooksImages/new-book-1.webp'),
#        (16, 'Microservices with Spring Boot', 'Walker, Susan',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 5, 5, 'BE',
#         '/Images/BooksImages/new-book-1.webp'),
#        (17, 'Ansible for DevOps', 'Hall, Charles',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 6, 6, 'DevOps',
#         '/Images/BooksImages/new-book-1.webp'),
#        (18, 'SQL Query Optimization', 'Allen, Karen',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 4, 4, 'DATA',
#         '/Images/BooksImages/new-book-1.webp'),
#        (19, 'Responsive Web Design', 'Young, Betty',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 7, 7, 'FE',
#         '/Images/BooksImages/new-book-1.webp'),
#        (20, 'Advanced Programming Concepts', 'King, Steven',
#         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec.', 3, 3, 'BE',
#         '/Images/BooksImages/new-book-1.webp');


# INSERT INTO review (id, book_id, date, rating, review_description, user_email)
# VALUES (1, 1, '2023-10-01', 5, 'Outstanding book for mastering Java. Highly recommend!', 'user1@example.com'),
#        (2, 1, '2023-10-02', 4, 'Very informative but could include more practical examples.', 'user2@example.com'),
#        (3, 1, '2023-10-03', 5, 'Clear and concise. Perfect for advanced Java learners.', 'user3@example.com');

#
# INSERT INTO user_roles (user_id, role_id)
# VALUES (1, 2),
#        (1, 3);

#
# INSERT INTO messages (id, admin_email, closed, question, response, title, user_email)
# VALUES (1, 'modi@example.com', false, 'What are the library timings?', 'Library is open from 9 AM to 9 PM.',
#         'Library Timings', 'user1@example.com'),
#        (2, 'modi@example.com', false, 'Can I borrow more than 2 books at a time?',
#         'No, the limit is 2 books at a time for one user.', 'Book Borrow Limit', 'user2@example.com'),
#        (3, 'modi@example.com', false, 'How can I request a book?',
#         'You can request a book by filling out the request form in your dashboard.', 'Book Request Process',
#         'user3@example.com'),
#        (4, 'modi@example.com', false, 'Is there a penalty for late returns?',
#         'Yes, a late fee of $0.5 per day is applicable.', 'Late Return Penalty', 'user4@example.com'),
#        (5, 'modi@example.com', false, 'Are eBooks available in the library?',
#         'Yes, you can access eBooks through our digital library section.', 'eBooks Availability', 'user5@example.com'),
#        (6, 'modi@example.com', false, 'Can I renew my book online?',
#         'Yes, renewal can be done through your account on our website.', 'Online Book Renewal', 'user6@example.com');


# INSERT INTO checkout (id, book_id, checkout_date, return_date, user_email)
# VALUES (14, 7, '2024-12-17', '2024-12-24', 'user@example.com');
#
