'use strict';
/*jshint esversion: 6 */

Cookie[] cks = request.getCookies();
		if (cks != null) {
			for (int i = 0; i < cks.length; i++) {
				String name = cks[i].getName();
				String value = cks[i].getValue();
				if (name.equals("auth")) {
					break; // exit the loop and continue the page
				}
				if (i == (cks.length - 1)) // if all cookie are not valid redirect to error page
				{
					response.sendRedirect("sessionExpired.html");
					return; // to stop further execution
				}
				i++;
			}
		} else {
			response.sendRedirect("sessionExpired.html");
			return; // to stop further execution
		}