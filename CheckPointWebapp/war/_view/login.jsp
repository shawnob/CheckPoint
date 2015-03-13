<!doctype html>

<html lang="en">
    <head>
        <title>Checkpoint Log In</title>
        <style type="text/css">
                body {
                        
                        background-color: white;
                }
                
                #title {
                        border-top: 3px solid grey;
                        border-bottom: 3px solid grey;
                        text-align: center;
                        font-size: 200%;
                        color: #000099;
                        
                    
                }
                </style>
    </head>
    <body>
        <div id="title">
        Welcome to Checkpoint
        </div>
        
        <div>
            Please Log in
            <form action="demo_form.asp">
			User Name: <input type="text" name="FirstName" value="zaphod"><br>
			Password: <input type="text" name="LastName" value="beeblebrox"><br>
			<input type="submit" value="Submit">
			</form>

			<!--Click the "Submit" button and the form-data will be sent to a page on the server called "demo_form.asp".-->
        </div>
    </body>
</html>