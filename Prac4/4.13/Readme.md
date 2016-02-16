
4.13 Send Redirect in Servlet
-----------------------------
When we want that someone else should handle the response of our servlet, then there we should use sendRedirect() method.
In send Redirect whenever the client makes any request it goes to the container, there the container decides whether the concerned servlet can handle the request or not. If not then the servlet decides that the request can be handle by other servlet or jsp. Then the servlet calls the sendRedirect() method of the response object and sends back the response to the browser along with the status code. Then the browser sees the status code and look for that servlet which can now handle the request. Again the browser makes a new request, but with the name of that servlet which can now handle the request and the result will be displayed to you by the browser. In all this process the client is unaware of the processing.
In this example we are going to make one html in which we will submit the user name and his password. The controller will check if the password entered by the user is correct or not. If the password entered by the user is correct then the servlet will redirect the request to the other servlet which will handle the request. If the password entered by the user is wrong then the request will be forwarded to the html form.


![prac4 13 ss](https://cloud.githubusercontent.com/assets/16948694/13069186/39b4c15a-d4a8-11e5-8693-c85a712e8e88.png)
