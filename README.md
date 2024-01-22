	Created a contact list app with a paging mechanism - each API call returns 20 items. Once the user scrolls to item no. 17 in the list, a new request is made to get the next items. 
	The app displays the first 60 elements (3 pages) of data from the remote source.
	To better highlight the paging mechanism, before each API call there a loading spinner appears for 3 seconds after the last item in each page.
    Each ContactItem has an Attachment icon - this is shown based on a random Boolean since there is no such flag in the API response
	The actions for the Menu, Search Bar and Floating action buttons have not been implemented yet.
