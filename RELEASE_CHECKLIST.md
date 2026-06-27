# Release Checklist

Use this checklist before publishing the public GitHub Release.

## Package Checks

1. Verify the zip contents.
2. Confirm the package contains the expected bridge jars:
   - `TDDUPJavaCombatBridge.jar`
   - `TTDUP_NPC_RenderBridge.jar`
   - `TDDUPFirearmAuthorityBridge.jar`
   - `TDDUPPrivateBodyBridge.jar`
3. Confirm the package contains report-only, install, verify, remove, and restore helpers.
4. Confirm the package contains user-facing notes.
5. Confirm there are no Steam credentials, GitHub tokens, personal files, private notes, or local machine paths that should not be public.
6. Confirm there are no auto-downloaders, telemetry hooks, or background-service installers.

## Repository Checks

1. Generate SHA256 checksums for the release zip.
2. Update `SHA256SUMS.txt`.
3. Update `VERSION.txt`.
4. Commit the docs and release-management files.
5. Push to GitHub.

## GitHub Pages

1. Confirm GitHub Pages is still enabled from the `main` branch and `/docs` folder.
2. Wait for GitHub Pages to publish.
3. Open the published Pages URL and confirm the install, uninstall, troubleshooting, security, and Workshop pages display correctly.

## GitHub Release

1. Draft a new GitHub Release.
2. Tag it:

```text
v3.5-compat-merge
```

3. Use a clear title:

```text
TDDUP Bridge Patcher v3.5 - Compatibility Merge
```

4. Upload this release asset:

```text
TDDUP_ProjectZomboid64_BridgePatcher_v3_5_CompatMerge.zip
```

5. Include the checksum from `SHA256SUMS.txt` in the release notes.
6. Mention that v3.5 preserves non-TDDUP Java entries and writes `TDDUP_Bridge_Compatibility_Report.txt`.
7. Publish the release.
8. Copy the final GitHub Release URL.
9. Replace `REPLACE_WITH_YOUR_GITHUB_RELEASE_URL` in the Steam Workshop description text.
10. Update the Steam Workshop description.

## Final Smoke Check

1. Confirm the Steam Workshop text says the external Java Bridge is required.
2. Confirm the docs do not say the Workshop item works by itself.
3. Confirm the GitHub Release asset downloads correctly.
4. Confirm the release zip checksum matches `SHA256SUMS.txt`.
