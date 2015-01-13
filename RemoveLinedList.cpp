void delete(Node **l, int target)
{
	if( *l == null )
		return;
		
	Node* head = *l;
	Node* curr = *l;
	Node* prev = null;	

	while( curr != null )
	{
		if( curr->data == target )
		{
			if( curr == head )
			{
				head = head->next;
				delete curr;
				curr = head;
			}
			else
			{
				prev->next = curr->next;
				delete curr;
				curr = prev->next;
			}
		}
		else
		{
			prev = curr;
			curr = curr->next;
		}
	}
	
	*l = head;
}
