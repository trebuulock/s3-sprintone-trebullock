const program = require('commander');
const crc = require('crc');
const http = require('http');
const fs = require('fs');
const path = require('path');
const generateToken = require('./tokenGenerator'); 


// Load the configuration from config.json
const configFilePath = path.join(__dirname, 'config', 'config.json');
const config = require(configFilePath);

// Load the users from user.json
const userFilePath = path.join(__dirname, 'user.json');
const userData = require(userFilePath);

// Define the CLI version and description
program.version('1.0.0').description('User Confirmation CLI');

// Load the confirm command module
const confirmCommand = require('./commands/confirm');
program
  .command('confirm <email>')
  .description('Confirm a new user account')
  .action(email => {
    confirmCommand(email);
    logEvent('User account confirmed', email);
  });

// Add new attributes to the config.json file
program
  .command('add-config-attribute <key> <value>')
  .description('Add a new attribute to the config.json file')
  .action((key, value) => {
    addConfigAttribute(key, value);
    logEvent('Added config attribute', `${key}: ${value}`);
  });

program.parse(process.argv);

function confirmCommand(email) {
  if (!email) {
    console.error('Please provide an email address to confirm.');
    return;
  }

  // Generate the unique token based on CRC32 hash of the email
  const token = generateToken(email);

  // Implement your logic to confirm the user account here
  console.log(`Confirming user account for ${email}`);
  console.log('Token:', token);
  console.log('API Key:', config.apiKey);
  console.log('DB URL:', config.dbUrl);

  // Update user.json with the confirmed user
  const user = {
    email,
    confirmed: true,
    timestamp: new Date().toISOString()
  };
  userData.users.push(user);
  saveUserJson();
}

const crc = require('crc');

function generateToken(value) {
  const crcValue = crc.crc32(value);
  const token = crcValue.toString(16).padStart(8, '0');
  return token;
}

module.exports = generateToken;

function logEvent(action, data) {
  const logEntry = `${new Date().toISOString()} - ${action}: ${data}\n`;
  const logFilePath = path.join(__dirname, 'events.log');

  // Create the events.log file if it doesn't exist
  if (!fs.existsSync(logFilePath)) {
    fs.writeFileSync(logFilePath, '');
  }

  // Append the log entry to the events.log file
  fs.appendFile(logFilePath, logEntry, err => {
    if (err) {
      console.error('Error writing to events log file:', err);
    }
  });
}

function saveUserJson() {
  fs.writeFile(userFilePath, JSON.stringify(userData, null, 2), err => {
    if (err) {
      console.error('Error saving user.json:', err);
    }
  });
}

// Create an HTTP server to handle the HTML page request
const server = http.createServer((req, res) => {
  if (req.url === '/') {
    fs.readFile(path.join(__dirname, 'index.html'), 'utf8', (err, data) => {
      if (err) {
        res.writeHead(500);
        res.end('Error loading the HTML page.');
      } else {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end(data);
      }
    });
  } else if (req.url.startsWith('/generateToken')) {
    const urlParams = new URLSearchParams(req.url.slice(req.url.indexOf('?')));
    const email = urlParams.get('email');
    const token = generateToken(email); // Use the generateToken function
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end(`Token: ${token}`);
    logEvent('Token generated', email);
  }
});


// Start the server on port 3000
server.listen(3000, () => {
  console.log('Server listening on port 3000');
  logEvent('Server started', 'Port 3000');
}); 
