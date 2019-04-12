import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, UrlSegment } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { DataService } from '../data.service';
import { routerNgProbeToken } from '@angular/router/src/router_module';
import { investValidator } from './../validators/investorValidator';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {

  messageForm: FormGroup;
  success: String = null;
  submitted = false;
  formObj;
  valid: boolean = true;

  constructor(private route: ActivatedRoute, private formBuilder: FormBuilder, private data: DataService) { }

  // Renders the form and load the detail of the client obj on startup
  ngOnInit() {

    this.formObj = JSON.parse(sessionStorage.getItem('updateID'));

    this.messageForm = this.formBuilder.group({
      _id: [this.formObj._id],
      name: [this.formObj.name, Validators.required],
      description: [this.formObj.description, Validators.required],
      investors: [this.formObj.investors, [Validators.required, investValidator]]
    });
    console.log(this.formObj);

  }


  // Makes a service call to put method api and updates the client object
  onUpdate(formObj1) {
    this.submitted = true;

    var str = formObj1['investors'] + '';
    var temp = new Array();
    if (str == '') {
      return;
    }
    temp = str.split(",");
    for (var a in temp) {
      temp[a] = parseInt(temp[a], 10);
    }
    formObj1['investors'] = temp;
    if (this.messageForm.valid) {
      this.data.updateClient(formObj1, this.formObj._id).subscribe(data => {
        sessionStorage.removeItem('updateID');
        this.success = 'success';
        this.valid = true;
      },
        error => {
          console.log("Error", error);
          this.valid = false;
        }
      );

    }
    this.valid = false;

    if (this.messageForm.invalid) {
      return;
    }
    this.messageForm.reset;
  }

}
