INSERT INTO product (id, quantity, price, description, image, name, is_active)
VALUES (
      1,
      10,
      20.00,
      'A nice pair of headphones',
      'https://i.insider.com/54eb437f6bb3f7697f85da71?width=1000&format=jpeg&auto=webp',
      'Headphones',
      true
  ),
  (
      2,
      5,
      45.00,
      'A nice TeeShirt',
      'https://d3o2e4jr3mxnm3.cloudfront.net/Mens-Jake-Guitar-Vintage-Crusher-Tee_68382_1_lg.png',
      'TeeShirt',
      true
  ),
  (
      3,
      20,
      2.50,
      'A reusable shopping bag',
      'https://images.ctfassets.net/5gvckmvm9289/3BlDoZxSSjqAvv1jBJP7TH/65f9a95484117730ace42abf64e89572/Noissue-x-Creatsy-Tote-Bag-Mockup-Bundle-_4_-2.png',
      'Shopping Bag',
      true
  ),
  (
      4,
      20,
      10.00,
      'A fancy cap for a fancy person',
      'https://d3o2e4jr3mxnm3.cloudfront.net/Rocket-Vintage-Chill-Cap_66374_1_lg.png',
      'Baseball Cap',
      true
  ),
  (
      5,
      3,
      80.00,
      'A nice coat',
      'https://www.pngarts.com/files/3/Women-Jacket-PNG-High-Quality-Image.png',
      'Coat',
      true
  );
INSERT INTO users (id, email, password, first_name, last_name, is_active, is_admin)
VALUES (
       1,
       'testuser@gmail.com',
       'password',
       'Test',
       'User',
       true,
       true
),
(
       2,
       'customer@gmail.com',
       'password',
       'Jane',
       'Doe',
       true,
       false
);