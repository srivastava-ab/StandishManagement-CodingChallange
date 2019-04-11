import { AbstractControl } from '@angular/forms';


  export function investValidator(control: AbstractControl) { 
    console.log(control.value);

    const regex = new RegExp('([0-9+])(,[0-9]+)*');
    const valid = regex.test(control.value);
    console.log(valid);
    return valid ? null : { invalidNumber: { valid: false, value: control.value } };
  }



