const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;
const os = require('os');

app.get('/', (req, res) => {
  const hostname = os.hostname();
  res.send(`
    <!DOCTYPE html>
    <html>
      <head>
        <title>Node Server</title>
        <style>
          body { font-family: Arial, sans-serif; margin: 50px; text-align: center; }
          .container { background-color: #e3f2fd; padding: 30px; border-radius: 8px; }
          h1 { color: #1976d2; }
          p { font-size: 18px; color: #333; }
          .info { background-color: #fff; padding: 15px; margin-top: 20px; border-left: 4px solid #1976d2; }
        </style>
      </head>
      <body>
        <div class="container">
          <h1>👋 Hello from Node.js Server!</h1>
          <p>This is the Express.js backend server</p>
          <div class="info">
            <p><strong>Server Hostname:</strong> ${hostname}</p>
            <p><strong>Technology:</strong> Node.js + Express.js</p>
            <p><strong>Port:</strong> 3000</p>
          </div>
        </div>
      </body>
    </html>
  `);
});

app.get('/api/health', (req, res) => {
  res.json({ status: 'healthy', server: 'node', hostname: os.hostname() });
});

app.listen(PORT, () => {
  console.log(`Node.js server running on port ${PORT}`);
});
