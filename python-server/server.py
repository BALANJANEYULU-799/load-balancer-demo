from flask import Flask, jsonify
import os
import socket

app = Flask(__name__)
PORT = int(os.getenv('PORT', 5000))

@app.route('/')
def hello():
    hostname = socket.gethostname()
    return f"""
    <!DOCTYPE html>
    <html>
      <head>
        <title>Python Server</title>
        <style>
          body {{ font-family: Arial, sans-serif; margin: 50px; text-align: center; }}
          .container {{ background-color: #f3e5f5; padding: 30px; border-radius: 8px; }}
          h1 {{ color: #7b1fa2; }}
          p {{ font-size: 18px; color: #333; }}
          .info {{ background-color: #fff; padding: 15px; margin-top: 20px; border-left: 4px solid #7b1fa2; }}
        </style>
      </head>
      <body>
        <div class="container">
          <h1>👋 Hello from Python Server!</h1>
          <p>This is the Flask backend server</p>
          <div class="info">
            <p><strong>Server Hostname:</strong> {hostname}</p>
            <p><strong>Technology:</strong> Python + Flask</p>
            <p><strong>Port:</strong> 5000</p>
          </div>
        </div>
      </body>
    </html>
    """

@app.route('/api/health')
def health():
    return jsonify({
        'status': 'healthy',
        'server': 'python',
        'hostname': socket.gethostname()
    })

if __name__ == '__main__':
    print(f'Python server running on port {PORT}')
    app.run(host='0.0.0.0', port=PORT, debug=False)
