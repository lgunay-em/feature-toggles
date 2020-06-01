import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormControl, Validators } from '@angular/forms';
import { FeaturesService } from './features.service';

@Component({
    selector: 'app-feature-form',
    templateUrl: 'feature-form.component.html',
    styleUrls: ['./feature-form.component.scss']
})
export class FeatureFormComponent {

    displayName = new FormControl('', []);
    technicalName = new FormControl('', [Validators.required]);
    description = new FormControl('', []);
    inverted = new FormControl('false', [Validators.required]);
    expiresOn = new FormControl();

    constructor(
        protected service: FeaturesService,
        protected dialogRef: MatDialogRef<FeatureFormComponent>,
        @Inject(MAT_DIALOG_DATA) public data: any) {
            if (data.feature) {
                const {
                    displayName,
                    technicalName,
                    description,
                    expiresOn,
                    inverted } = data.feature;

                this.displayName.setValue(displayName);
                this.technicalName.setValue(technicalName);
                this.description.setValue(description);
                this.inverted.setValue(inverted.toString());
                this.expiresOn.setValue(expiresOn);
            }
    }

    onCancel(): void {
        this.dialogRef.close();
    }

    onOK(): void {
        const feature = {
            displayName: this.displayName.value,
            technicalName: this.technicalName.value,
            description: this.description.value,
            inverted: this.inverted.value === 'true',
            expiresOn: this.expiresOn.value
        };

        if (this.data.new) {
            this.service.createNew(feature).subscribe(() => {
                this.dialogRef.close();
            });
        } else {
            this.service.update({
                id: this.data.feature.id,
                ...feature
            }).subscribe(() => {
                this.dialogRef.close();
            });
        }
    }

    getErrorMessage() {
        if (this.technicalName.hasError('required')) {
            return 'You must enter a value';
        }
    }
}
