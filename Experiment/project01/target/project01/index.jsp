<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="p3.css">
    <title>practicel_3</title>
</head>

<body>
    <div class="register-form">
        <h2>User Registration</h2>
        <input type="text" id="loginAccount" placeholder="Login Account: Please enter your login account">
        <input type="password" id="password" placeholder="Password: Please enter your password">
        <input type="password" id="confirmPassword" placeholder="Confirm Password: Please re-enter your password">
        <input type="text" id="name" placeholder="Name: Please enter your name">
        <input type="text" id="idCard" placeholder="ID Card Number: Please enter an 18-digit ID card number">
        <input type="text" id="birthDate" placeholder="Date of Birth: Format: yyyy-mm-dd">
        <input type="text" id="address" placeholder="Address: Please enter your address">
        <input type="text" id="postcode" placeholder="Postcode: Please enter a 6-digit postcode">
        <input type="text" id="email" placeholder="E-mail: Please enter your email">
        <button onclick="register()">Register</button>
    </div>
    <script>
        function register() {
            const loginAccount = document.getElementById('loginAccount').value;
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('confirmPassword').value;
            const name = document.getElementById('name').value;
            const idCard = document.getElementById('idCard').value;
            const birthDate = document.getElementById('birthDate').value;
            const address = document.getElementById('address').value;
            const postcode = document.getElementById('postcode').value;
            const email = document.getElementById('email').value;

            if (!/^[a-zA-Z][a-zA-Z0-9]*$/.test(loginAccount)) {
                alert('The login account should start with a letter and contain only letters and numbers.');
                document.getElementById('loginAccount').focus();
                return;
            }

            if (password.length < 8 ||!/[a-zA-Z]/.test(password) ||!/\d/.test(password) ||!/[^a-zA-Z0-9]/.test(password)) {
                alert('The password should be at least 8 characters long and contain letters, numbers, and non-alphanumeric characters.');
                document.getElementById('password').focus();
                return;
            }

            if (password!== confirmPassword) {
                alert('The passwords entered twice do not match.');
                document.getElementById('confirmPassword').focus();
                return;
            }

            if (name === '') {
                alert('Please enter your name.');
                document.getElementById('name').focus();
                return;
            }

            if (!/^\d{17}[\dXx]$/.test(idCard)) {
                alert('Please enter a valid 18-digit ID card number.');
                document.getElementById('idCard').focus();
                return;
            }

            if (!/^\d{4}-\d{2}-\d{2}$/.test(birthDate)) {
                alert('The date of birth should be in the format yyyy-mm-dd.');
                document.getElementById('birthDate').focus();
                return;
            }
            const birthYear = parseInt(birthDate.split('-')[0]);
            const idCardYear = parseInt(idCard.slice(6, 10));
            if (birthYear!== idCardYear) {
                alert('According to the date of birth, the ID card number is invalid.');
                document.getElementById('idCard').focus();
                return;
            }

            if (address === '') {
                alert('Please enter your address.');
                document.getElementById('address').focus();
                return;
            }

            if (!/^\d{6}$/.test(postcode)) {
                alert('The postcode should be a 6-digit number.');
                document.getElementById('postcode').focus();
                return;
            }

            if (!/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(email)) {
                alert('Please enter a valid email address.');
                document.getElementById('email').focus();
                return;
            }

            alert('Registration successful!');

            document.getElementById('loginAccount').value = '';
            document.getElementById('password').value = '';
            document.getElementById('confirmPassword').value = '';
            document.getElementById('name').value = '';
            document.getElementById('idCard').value = '';
            document.getElementById('birthDate').value = '';
            document.getElementById('address').value = '';
            document.getElementById('postcode').value = '';
            document.getElementById('email').value = '';
        }
    </script>
</body>

</html>