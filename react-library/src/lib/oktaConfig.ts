export const oktaConfig = {
    clientId: '6LQCKFhX7ARmRaMu4q5Q8zvqDD2FYVtI',
    issuer: 'https://dev-ht1yi1f6phaiee7u.us.auth0.com/oauth2/default',
    redirectUri: 'http://localhost:3000/login/callback',
    scopes: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttpsCheck: true
}