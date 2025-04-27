INSERT INTO `xet-da-furia-db`.`usuarios` (id, nome, email, senha) VALUES
('77eea251-9b21-42b1-b9cf-276035b66ed7', 'João Silva', 'joao@example.com', 'senha123'),
('37997bb5-8bba-4707-ae13-6d89b4cdf668', 'Maria Oliveira', 'maria@example.com', 'senha123'),
('b634becf-47f9-4c99-a45e-f00f531e29bb', 'Carlos Souza', 'carlos@example.com', 'senha123'),
('a1b2c3d4-e5f6-7890-ab12-cd34ef56gh78', 'Ana Lima', 'ana@example.com', 'senha123'),
('b2c3d4e5-f678-9012-bc34-de56fa78gh90', 'Pedro Santos', 'pedro@example.com', 'senha123'),
('c3d4e5f6-7890-1234-cd56-ef78ga90hb12', 'Fernanda Costa', 'fernanda@example.com', 'senha123'),
('d4e5f678-9012-3456-de78-fa90hb12ic34', 'Lucas Almeida', 'lucas@example.com', 'senha123'),
('e5f67890-1234-5678-ef90-ga12ic34jd56', 'Paula Mendes', 'paula@example.com', 'senha123'),
('f6789012-3456-7890-fa12-hb34jd56ke78', 'Ricardo Gonçalves', 'ricardo@example.com', 'senha123'),
('67890123-4567-8901-ga34-ic56ke78lf90', 'Beatriz Martins', 'beatriz@example.com', 'senha123');


INSERT INTO `chats` (`id`, `nome`, `descricao`, `jogo`, `tema`, `usuario_id`) VALUES
('12ab416b-62ad-4d8b-9a03-c10f33447c21', 'Discussão Major Copenhague', 'Comente aqui tudo sobre as partidas do Major de Copenhague!', 'CS2', 'DISCUSSAO_DE_PARTIDA', '77eea251-9b21-42b1-b9cf-276035b66ed7'),
('98181834-2c9b-4e95-8650-8c0252098739', 'Zoação Pós-Partida', 'Só resenha e zoeira liberada depois dos jogos!', 'CS2', 'MEMES', '77eea251-9b21-42b1-b9cf-276035b66ed7'),
('c4dd5846-3ce1-4d72-b32e-a99ca10ea64d', 'Novidades do Valorant', 'Notícias e novidades sobre a FURIA no Valorant.', 'VALORANT', 'NOTICIAS', '77eea251-9b21-42b1-b9cf-276035b66ed7'),
('cc843694-019b-4d55-932f-0ec9aad44326', 'Melhores Jogadas Valorant', 'Compartilhe clipes e jogadas épicas no Valorant!', 'VALORANT', 'HIGHLIGHTS', '77eea251-9b21-42b1-b9cf-276035b66ed7'),
('e9ccaa9e-f9d3-4ab6-a938-4b90d4ac364e', 'Análises de Estratégias R6', 'Debate de táticas e setups no Rainbow Six.', 'RAINBOW_SIX', 'ANALISES_ESTRATEGICAS', '77eea251-9b21-42b1-b9cf-276035b66ed7'),
('468353e5-14f9-4b34-80dd-5d4c7b8f7671', 'Comunidade PUBG', 'Converse sobre jogadas, drops e partidas no PUBG!', 'PUBG', 'DISCUSSAO_DE_PARTIDA', '77eea251-9b21-42b1-b9cf-276035b66ed7'),
('bf4db5ff-2299-47de-b797-4dcc2ad65963', 'Zoação no LoL', 'Manda seus memes e histórias engraçadas de League!', 'LEAGUE_OF_LEGENDS', 'MEMES', '77eea251-9b21-42b1-b9cf-276035b66ed7'),
('f3f7a654-f5d0-4459-a13f-edd261abe149', 'Eventos de Rocket League', 'Fique por dentro dos eventos de Rocket League.', 'ROCKET_LEAGUE', 'EVENTOS_E_CAMPEONATOS', '77eea251-9b21-42b1-b9cf-276035b66ed7'),
('ba636156-91c9-4cf6-9780-de6a1f542c8b', 'Dicas de Apex', 'Troque dicas de jogo e treinos em Apex Legends.', 'APEX_LEGENDS', 'TREINOS_E_TATICA', '77eea251-9b21-42b1-b9cf-276035b66ed7'),
('5856d849-c55b-4ec1-b479-f0dab79b3908', 'Fighting Games Arena', 'Bate-papo para fãs de jogos de luta!', 'FIGHTING_GAMES', 'OFF_TOPIC', '77eea251-9b21-42b1-b9cf-276035b66ed7');

INSERT INTO `xet-da-furia-db`.`usuario_chat` (usuario_id, chat_id) VALUES
  ('77eea251-9b21-42b1-b9cf-276035b66ed7', '12ab416b-62ad-4d8b-9a03-c10f33447c21'),
  ('37997bb5-8bba-4707-ae13-6d89b4cdf668', '98181834-2c9b-4e95-8650-8c0252098739'),
  ('b634becf-47f9-4c99-a45e-f00f531e29bb', 'c4dd5846-3ce1-4d72-b32e-a99ca10ea64d'),
  ('a1b2c3d4-e5f6-7890-ab12-cd34ef56gh78', 'cc843694-019b-4d55-932f-0ec9aad44326'),
  ('b2c3d4e5-f678-9012-bc34-de56fa78gh90', 'e9ccaa9e-f9d3-4ab6-a938-4b90d4ac364e'),
  ('c3d4e5f6-7890-1234-cd56-ef78ga90hb12', '468353e5-14f9-4b34-80dd-5d4c7b8f7671'),
  ('d4e5f678-9012-3456-de78-fa90hb12ic34', 'bf4db5ff-2299-47de-b797-4dcc2ad65963'),
  ('e5f67890-1234-5678-ef90-ga12ic34jd56', 'f3f7a654-f5d0-4459-a13f-edd261abe149'),
  ('f6789012-3456-7890-fa12-hb34jd56ke78', 'ba636156-91c9-4cf6-9780-de6a1f542c8b'),
  ('67890123-4567-8901-ga34-ic56ke78lf90', '5856d849-c55b-4ec1-b479-f0dab79b3908');

