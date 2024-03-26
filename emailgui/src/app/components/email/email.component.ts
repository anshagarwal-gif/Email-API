
import { Component,OnInit } from '@angular/core';
import { EmailService } from '../../service/email.service';
import { response } from 'express';
import { error } from 'console';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrl: './email.component.css'
})
export class EmailComponent implements OnInit {
	
	
	data={
		to:"",
		subject:"",
		message:""
		
		
		
		
	}
	
	flag:boolean=false;
	
	constructor(private email: EmailService, private snak: MatSnackBar){}
	ngOnInit():void{
		
	}
	
 doSubmitForm()
 {
	 console.log("submitted");
	 if(this.data.to=='' || this.data.subject=='')
	 {
		 this.snak.open("fields can not be empty", "OK");
		 return;
	 }
	 
	 this.flag=true;
	 this.email.sendEmail(this.data).subscribe(
	 response=>{
		 console.log(response);
		 this.flag=false;
		 this.snak.open("Send Successfully", "Ok");
	 },
	 error=>{
		 console.log(error);
		 this.flag=false;
		 this.snak.open("Error", "Dismiss");
	 }
	 
	 )
 }
}
