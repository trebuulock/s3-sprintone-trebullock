const config = require('../config/config');
const program = require('commander');

// Define the confirm command
program
  .arguments('<email>')
  .description('Confirm a new user account')
  .action(email => {
    confirmCommand(email);
  });

function confirmCommand(email) {
  if (!email) {
    console.error('Please provide an email address to confirm.');
    return;
  }

  // Implement your logic to confirm the user account here
  // For example, you can update the user's account status to confirmed in the database
  console.log(`Confirming user account for ${email}`);
  console.log('API Key:', config.apiKey);
  console.log('DB URL:', config.dbUrl);
}

module.exports = program;
