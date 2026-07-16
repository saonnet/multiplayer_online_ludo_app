1. Don't be a feature creep.
2. Good is better than perfect.
3. Focus on core work over than decorations
4. Think of the whole thing, then strip down

# Home Page

1. Login and signup button on top right.
2. Popup based login or sign up.
2. 1 Play now button left center(vertically)
3. Clicking on play now shows popup
4. Popup has 3 options -- 1. Join room by key, 2. Join random room, 3. Create a room
5. Clicking on join room by key, popup changes to an input field for key, captcha and join button, if room found take to game
6. Clicking on join random room, captcha, match for game happens, we can search in user selected server based on ping but for our impl. we can search all servers to keep things simple, joins best room, take to game screen
7. Clicking on create room, captcha,s create a room, take to game 
8. Captcha not shown if user is signed in.
9. Error messages if game not found etc. are shown in popup itself.

# Game room

1. If user not signed in, ask him for username, prompt about not signed in and show sign in/up button too.(maybe we don't show sign in/up here in this page for now and user has to be either signed in or deal with it before joining a game)
2. If user has created a room, share room key or link while he is choosing his avatar
3. Username and avatar can be cached in system and reused again and again, along with other settings even for non signed in users.
4. For signed in users, it'll be fetched from db.
5. No double password check in sign up form for simplicity

# Choices

1. Google recaptcha instead of hcaptcha as it's more recognizable on resume + 10k free each month so will work for small project, ideally I would have used hcaptcha as it's free. Captcha logic should be modular so it can be replaced in future if site gets more traffic.
2. Not letting users select servers in matchmaking to keep it simple, in real world we'll do it.
3. Not letting users select their colors in game, in real world we'll do it. We don't have preferred colors for signed in users too whch will be there in real world.