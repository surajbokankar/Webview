#  Bridge between Android and Web pages via Webview.

 We wanted to have access web events in some cases where we found it necessary to communicate app and web so this project will 
 help to do so.
  
In project files you will find Demo.html which a static web page which has defined required html and JS fucntions.
Same JS function(Click events) we are handling from app using JavascriptInterface class.

# Steps:
To host local html file I used Firbase hosting as a medium.
1]To get started with Firbase hosting you need to have node.js install
 https://nodejs.org/en/download/package-manager/

2] Install Firbase CLI:
npm install -g firebase-tools

3]Init Firbase project:
  firebase init # If throws error please login 
  firebase login
  
4] Deploy your html content on firebase:
firebase deploy

# Optional:
 1] If wanted to check on local:
 firebase serve
 2] To login again:
 firebase login --reauth
 

  
  
   
