import { Component } from '@angular/core';

import { environment } from '../../environments/environment';
import { Feature } from './features.model';
import { FeaturesService } from './features.service';
import { Observable, of } from 'rxjs';
import { FeatureFormComponent } from './feature-form.component';
import { MatDialog } from '@angular/material/dialog';
import { ArchiveComponent } from './archive.component';

@Component({
  selector: 'app-features',
  templateUrl: './features.component.html',
  styleUrls: ['./features.component.scss']
})
export class FeaturesComponent {

  data$: Observable<Feature[]>;
  currentPage = 0;

  displayedColumns: string[] = ['displayName', 'technicalName', 'inverted', 'expires', 'description', 'archived', 'operations'];

  constructor(
    protected service: FeaturesService,
    protected dialog: MatDialog) {
    this.load();
  }

  load() {
    this.data$ = this.service.getAll(this.currentPage);
  }

  paginate({ pageIndex }) {
    this.currentPage = pageIndex;
    this.data$ = this.service.getAll(pageIndex);
  }

  newDialog() {
    const dialogRef = this.dialog.open(FeatureFormComponent, {
      width: '500px',
      data: {
        new: true
      }
    });

    this.closeDialog(dialogRef);
  }

  editDialog(feature) {
    const dialogRef = this.dialog.open(FeatureFormComponent, {
      width: '500px',
      data: {
        edit: true,
        feature
      }
    });

    this.closeDialog(dialogRef);
  }

  archiveDialog(feature, archive) {
    const dialogRef = this.dialog.open(ArchiveComponent, {
      width: '500px',
      data: {
        feature,
        archive
      }
    });

    this.closeDialog(dialogRef);
  }

  closeDialog(dialogRef) {
    dialogRef.afterClosed().subscribe((ok) => {
      if (ok) {
        setTimeout(this.load.bind(this), 200);
      }
    });
  }
}
