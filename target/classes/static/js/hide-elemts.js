document.addEventListener("DOMContentLoaded", function () {
                        setTimeout(function () {
                          const errorNames = document.getElementById('error-names');
                          const errorSurNames = document.getElementById('error-surnames');
                          const errorEmail = document.getElementById('error-email');
                          const errorPhone = document.getElementById('error-phone');
                          const errorBirthdate = document.getElementById('error-birthdate');
                          const errorPasswords = document.getElementById('error-passwords');
                          const errorWeakPassword = document.getElementById('error-invalid-password');

                          //error-invalid-password

                          if (errorNames) errorNames.style.display = 'none';
                          if (errorSurNames) errorSurNames.style.display = 'none';
                          if (errorEmail) errorEmail.style.display = 'none';
                          if (errorPhone) errorPhone.style.display = 'none';
                          if (errorBirthdate) errorBirthdate.style.display = 'none';
                          if (errorPasswords) errorPasswords.style.display = 'none';
                          if (errorWeakPassword) errorWeakPassword.style.display = 'none';


                        }, 5000);