import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, FormGroupDirective } from '@angular/forms';
import { DataService } from '../data.service';
import { investValidator } from './../validators/investorValidator';



@Component({
  selector: 'app-add-new',
  templateUrl: './add-new.component.html',
  styleUrls: ['./add-new.component.scss']
})
export class AddNewComponent implements OnInit {
  messageForm: FormGroup;
  success: String = null;
  submitted = false;
  formObj: Object;
  valid: boolean = true;
  error: String;

  constructor(private formBuilder: FormBuilder, private data: DataService) { }

  ngOnInit() {
    this.messageForm = this.formBuilder.group({
      _id: ['', Validators.required],
      name: ['', Validators.required],
      description: ['', Validators.required],
      investors: ['', [Validators.required]]
    });
  }

  onSubmit(formObj, formDirective: FormGroupDirective) {
    this.error = '';
    this.valid=true;
    this.submitted = true;
    var str = formObj['investors'] + +'';
    var temp = new Array();
    if (str == '') {
      return;
    }
    temp = str.split(",");
    for (var a in temp) {
      temp[a] = parseInt(temp[a], 10);
    }
    formObj['investors'] = temp;
    if (this.messageForm.valid) {
      this.data.addClients(formObj).subscribe(data => {
        this.valid = true;
        this.success = 'success';
      },
        error => {
          this.error = error.error.message;
          console.log("Error11-->", error);

          console.log("Error-->", error.error.message);
          this.valid = false;
        }
      );
    }
    this.messageForm.clearAsyncValidators;
    this.messageForm.clearValidators;
    this.messageForm.reset
    
    console.log("--> " + this.error);
    this.valid = false;
    if (this.messageForm.invalid) {
      return;
    }
  }

}