import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FeaturesService } from './features.service';

@Component({
    selector: 'app-archive-feature',
    templateUrl: 'archive.component.html',
    // styleUrls: ['./archive.component.scss']
})
export class ArchiveComponent {

    constructor(
        protected service: FeaturesService,
        protected dialogRef: MatDialogRef<ArchiveComponent>,
        @Inject(MAT_DIALOG_DATA) public data: any) {
    }

    onCancel(): void {
        this.dialogRef.close();
    }

    onOK(archive): void {
        this.service.update({
            ...this.data.feature,
            archived: archive
        }).subscribe(() => {
            this.dialogRef.close();
        });
    }
}
