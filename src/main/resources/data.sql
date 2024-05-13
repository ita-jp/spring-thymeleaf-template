INSERT INTO users (username, password, enabled)
VALUES ('admin1', '{bcrypt}$2a$10$sTBfM4VKzLXsLuvrJHLN7efcG7356vRxPGfOaHCQdDJKGw2lhwmQu', true)
     , ('user1', '{bcrypt}$2a$10$8SfmyreH9pc1XFhlt4swS.IBCw4esQfnerov9QATtT4y9nmfW.UWG', true)
     , ('user2', '{bcrypt}$2a$10$mHx/C8fDZpyypfV15PFgAOw53dNm7wTw.f5YVpLOXp6uNG6jrqN.S', true)
     , ('user3', '{bcrypt}$2a$10$S.BpJRz0e.Jl16xaviksm.FXpPOMYgPwi0pmR7SK0RMniGrEnqntG', true)
;

INSERT INTO authorities (user_id, authority)
VALUES (1, 'ADMIN')
     , (2, 'USER')
     , (3, 'USER')
     , (4, 'USER')
;
